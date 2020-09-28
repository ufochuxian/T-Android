#include "cocos/platform/android/jni/JniHelper.h"
#include <jni.h>
#include <android/log.h>

#if PACKAGE_AS
#include "PluginJniHelper.h"
#include "SDKManager.h"
#endif

//#define  LOG_TAG    "main"
//#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

#ifndef TEST_H
#define TEST_H

extern "C" {
//c++层回调java上层
static JNIEXPORT void JNICALL
reportJSException(JNIEnv *env, const char *location, const char *message,
                  const char *stack) {
    jclass jc = env->FindClass("com/jiliguala/niuwa/module/game/NativeGameActivity");
    jmethodID methodId = env->GetStaticMethodID(jc, "reportJSException", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
    jstring loca = env->NewStringUTF(location);
    jstring mess = env->NewStringUTF(message);
    jstring stac = env->NewStringUTF(stack);
    env->CallStaticVoidMethod(jc, methodId, loca, mess, stac);
}
}
#endif