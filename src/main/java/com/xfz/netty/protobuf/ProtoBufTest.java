package com.xfz.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @describe
 * @Author: xfz
 * @Date: 2019/3/25 16:43
 */
public class ProtoBufTest {
    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("小明").setAge(24).setAddress("海口").build();

        byte[] stu = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(stu);
        System.out.println(student1.getName());

    }
}
