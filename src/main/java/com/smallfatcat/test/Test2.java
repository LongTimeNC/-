package com.smallfatcat.test;

/**
 * @author zsz
 * @Description
 * @date 2022/9/7
 */
public class Test2 {
    public static void main(String[] args) {
        //学生数组
        Student[] students = new Student[3];
        //字符串
        String str = "Tom#15,jack#16,Dava#20";
        //通过,分割
        String[] splits1 = str.split(",");
        for (int i = 0;i < splits1.length;i++){
            //通过#分割
            String[] splits2 = splits1[i].split("#");
            for (int j = 0;j < splits2.length;j++){
                //学生对象
                Student student = new Student();
                student.setName(splits2[0]);
                student.setAge(splits2[1]);
                //将对象添加到数组中
                students[i] = student;
            }
        }
        //遍历数组
        for (Student student : students){
            System.out.println(student);
        }
    }
}
