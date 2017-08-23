
//JNI是一个协议，这个协议用来沟通java代码和外部的本地代码(c/c++)
#include <jni.h>
#include <string>

extern "C" {

    //第一个参数为Java虚拟机的内存地址的二级指针，用于本地方法与java虚拟机在内存中交互
        // JNI 方便java 语言和 c++ 进行通信。 使用 指针 指向 java 虚拟机中的内存地址
    //第二个参数为一个java对象，即是哪个对象调用了这个 c方法
    JNIEXPORT jstring JNICALL
    Java_com_test_jnicamera_JniUtils_stringFromJNI(JNIEnv *env, jobject instance);

    JNIEXPORT void JNICALL
    Java_com_test_jnicamera_JniUtils_SurfaceCreatedNdk(JNIEnv *env, jobject instance);

}

// code 的实现
//  JNIEXPORT和JNICALL都是JNI的关键字，表示此函数是要被JNI调用的
JNIEXPORT jstring JNICALL
Java_com_test_jnicamera_JniUtils_stringFromJNI(JNIEnv *env, jobject instance) {

    std::string hello = "Hello from C++2";

    // 返回值是java字符串，所以要将C语言的字符串转换成java的字符串
    return env->NewStringUTF(hello.c_str());

}

JNIEXPORT void JNICALL
Java_com_test_jnicamera_JniUtils_SurfaceCreatedNdk(JNIEnv *env, jobject instance) {
}