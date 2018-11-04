package com.rico.study;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;

/**
 * @author rico
 * @version 1.0
 * @description: 计算工程目录下文件的数量 默认计算java文件的
 * @createtime: 2018/11/3 22:27
 */
@Mojo(name = "myplugin")
public class CountFiles extends AbstractMojo {

    /**读取配置里的msg标签内容*/
    @Parameter
    private String msg;

    /**读取options标签里的内容 格式是List<String>*/
    @Parameter
    private List<String> options;

    /**需要读取的路径 默认为${basedir}*/
    @Parameter(property = "basedir")
    private String filepath;

    /**文件类型 默认统计java文件*/
    @Parameter(defaultValue = "java")
    private static String fileName;

    /**默认文件数量为零*/
    static int count=0;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("Get Msg: " + msg);
        System.out.println("Get options: " + options);
        getFiles(filepath);
        System.out.println("Total file is: " + count);
    }

    private static void getFiles(String filepath){
        File file = new File(filepath);
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            if (!listfile[i].isDirectory()) {
                if (listfile[i].toString().endsWith(fileName)){
                    count++;
                }
            } else {
                getFiles(listfile[i].toString());
            }
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
