package clazzLoad_reflect.clazzLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: CompileClassLoader
 * Description: 自定义ClassLoader（重写findCLass()方法实现）
 * 这个ClassLoader可以在加载类之前先编译该类的源文件
 * 这样就可以通过该ClassLoader直接运行Java源文件
 *
 * 使用命令时去掉包名进行编译运行 ，不然会ClassNotFound
 * date: 2019/12/14 11:45
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class CompileClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 如果运行该程序时没有参数，即没有目标类
        if (args.length < 1) {
            System.out.println("缺少目标类，请按照如下格式运行Java文件：");
            System.out.println("java CompileClassLoader ClassName");
        }

        // 第一个参数时需要运行的类
        String progClass = args[0];
        // 剩下的参数将作为运行目标类时的参数，将这些参数复制到一个新的数组中
        String[] progArgs = new String[args.length-1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CompileClassLoader ccl = new CompileClassLoader();

        // 加载需要运行的类
        Class<?> clazz = ccl.loadClass(progClass);
        // 获取需要运行的类的主方法
        Method main = clazz.getMethod("main", (new String[0]).getClass());
        Object argsArray[] = {progArgs};
        main.invoke(null, argsArray);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //将包路径中的.替换成/
        String fileStub = name.replace(".","/");
        String javaFilename = fileStub+".java";
        String classFilename = fileStub+".class";
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);

        // 当java文件存在，Class文件不存在   或者  java文件修改时间比Class文件修改时间更晚   重新编译
        if ((javaFile.exists() && !classFile.exists()) || (javaFile.lastModified() > classFile.lastModified())) {
            try {
                // 如果编译失败，或者.class文件不存在   抛出异常
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:"+javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 如果.class文件存在，将这个文件转换成Class对象
        if (classFile.exists()) {
            try {
                // 将.class文件的二进制数据读入数组
                byte[] raw = getBytes(classFilename);
                // 调用ClassLoader的defineClass方法将二进制数据转换为CLass对象
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 如果没有获取到clazz对象，表明加载失败，抛出异常
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }

        return clazz;
    }

    /**
     * 读取一个文件的内容
     * @param fileName 文件名
     * @return
     */
    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];

        try(FileInputStream fin = new FileInputStream(file)) {
            // 一次读取Class文件的全部二进制数据
            int r = fin.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部文件："+r+" != "+len);
            }
        }
        return raw;
    }

    /**
     * 定义编译指定Java文件的方法
     * @param javaFile
     * @return
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("JYK的CompileClassLoader正在编译"+javaFile+"...");

        // 调用系统的javac命令，我这里因为用了utf-8 所以要加上后面这个参数
        Process p = Runtime.getRuntime().exec("javac "+javaFile+" -encoding utf-8");
        System.out.println(javaFile);

        try {
            // 其他线程都等着这个线程完成
            p.waitFor();
        } catch (InterruptedException e) {
            System.out.println("==="+e);
            e.printStackTrace();
        }
        // 获取javac线程的退出值
        int ret = p.exitValue();
        // 当退出值为0时，编译成功
        return ret==0;
    }
}
