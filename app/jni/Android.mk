LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := cocos2djs_shared

LOCAL_MODULE_FILENAME := libcocos2djs

ifeq ($(USE_ARM_MODE),1)
LOCAL_ARM_MODE := arm
endif

LOCAL_SRC_FILES := jni/main.cpp \
				   jni/AppDelegate.cpp \
				   jni/jsb_module_register.cpp \
				   jni/bridge.cpp \

LOCAL_C_INCLUDES := $(LOCAL_PATH)/jni

LOCAL_STATIC_LIBRARIES := cocos2dx_static

include $(BUILD_SHARED_LIBRARY)

$(call import-module, cocos)
