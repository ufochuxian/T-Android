/****************************************************************************
 Copyright (c) 2017-2018 Xiamen Yaji Software Co., Ltd.

 http://www.cocos.com

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated engine source code (the "Software"), a limited,
 worldwide, royalty-free, non-assignable, revocable and non-exclusive license
 to use Cocos Creator solely to develop games on your target platforms. You shall
 not use Cocos Creator software for developing other software or tools that's
 used for developing games. You are not granted to publish, distribute,
 sublicense, and/or sell copies of Cocos Creator.

 The software or tools in this License Agreement are licensed, not sold.
 Xiamen Yaji Software Co., Ltd. reserves all rights not expressly granted to you.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/

#include "AppDelegate.h"

#include "cocos2d.h"
#include "bridge.cpp"

#include "cocos/scripting/js-bindings/manual/jsb_module_register.hpp"
#include "cocos/scripting/js-bindings/manual/jsb_global.h"
#include "cocos/scripting/js-bindings/jswrapper/SeApi.h"
#include "cocos/scripting/js-bindings/event/EventDispatcher.h"
#include "cocos/scripting/js-bindings/manual/jsb_classtype.hpp"
#include "android/log.h"

#define  APPDELEGATE_LOG_TAG    "AppDelegate"
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,APPDELEGATE_LOG_TAG,__VA_ARGS__)

USING_NS_CC;

AppDelegate::AppDelegate(int width, int height) : Application("Cocos Game", width, height) {
}

AppDelegate::~AppDelegate() {
}

bool AppDelegate::applicationDidFinishLaunching() {
    LOGD("check-applicationDidFinishLaunching step1");

    se::ScriptEngine *se = se::ScriptEngine::getInstance();

    jsb_set_xxtea_key("842af34f-6c9d-4b");
    jsb_init_file_operation_delegate();

#if defined(COCOS2D_DEBUG) && (COCOS2D_DEBUG > 0)
    // Enable debugger here
    jsb_enable_debugger("0.0.0.0", 6086, false);
#endif
    se->setExceptionCallback([](const char *location, const char *message, const char *stack) {
        //Attach主线程
        JNIEnv *env;
        if (JniHelper::getJavaVM()->GetEnv((void **) &env, JNI_VERSION_1_4) != JNI_OK || !env) {
            return 0;
        }
        reportJSException(env, location, message, stack);
    });
    jsb_register_all_modules();

    se->start();
    LOGD("check-applicationDidFinishLaunching step2");
    
    se::AutoHandleScope hs;

    jsb_run_script("jsb-adapter/jsb-builtin.js");
    LOGD("check-applicationDidFinishLaunching step3");

    jsb_run_script("main.js");
    LOGD("check-applicationDidFinishLaunching step4");

    se->addAfterCleanupHook([]() {
        JSBClassType::destroy();
    });
    LOGD("check-applicationDidFinishLaunching step5");
    return true;
}

// This function will be called when the app is inactive. When comes a phone call,it's be invoked too
void AppDelegate::applicationDidEnterBackground() {
    startCocos();
    EventDispatcher::dispatchEnterBackgroundEvent();
}

// this function will be called when the app is active again
void AppDelegate::applicationWillEnterForeground() {
    EventDispatcher::dispatchEnterForegroundEvent();
}

void AppDelegate::startCocos() {
#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
    JniMethodInfo minfo;
    bool isHaveFunction = JniHelper::getStaticMethodInfo(minfo,
                                                         "com/jiliguala/niuwa/module/game/CocosBackGroundActivity",
                                                         "startCocos", "()V");
    if (!isHaveFunction) {
        LOGD("startCocos - JNI:can't find function");
    } else {
        LOGD("startCocos - JNI:execute function");
        minfo.env->CallStaticVoidMethod(minfo.classID, minfo.methodID);
        minfo.env->DeleteLocalRef(minfo.classID);
    }
#endif
}
