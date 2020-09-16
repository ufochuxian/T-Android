package com.tgm.common.mgr


/**

 * @Auther: chen

 * @datetime: 2020-09-16

 * @desc:

 */
class UrlMgr {

    private var urlMap : HashMap<String,String>? = null

    companion object {
        var DEFAULT_URL_KEY = "tgm_default_url_key"

        @Volatile
        private var instance: UrlMgr? = null

        open fun getInstance(): UrlMgr {
            if (instance == null) {
                synchronized(UrlMgr::class.java) {
                    if (instance == null) {
                        instance = UrlMgr()
                    }
                }
            }
            return instance!!
        }

    }

    /**
     * 一次性传入urlMap
     *
     * @param urlMap map
     */
    fun setMultipleUrl(map: HashMap<String, String>?): UrlMgr {
        urlMap = map
        return this
    }

    /**
     * 向map中添加url
     *
     * @param urlKey   key
     * @param urlValue value
     */
    fun addUrl(urlKey: String, urlValue: String): UrlMgr {
        urlMap?.put(urlKey,urlValue)
        return this
    }

    /**
     * 从map中删除某个url
     *
     * @param urlKey 需要删除的urlKey
     * @return com.jiliguala.niuwa.coremodel.http.manager.UrlMgr
     */
    fun removeUrlByKey(urlKey: String): UrlMgr {
        urlMap?.remove(urlKey)
        return this
    }

    /**
     * 针对单个baseUrl切换的时候清空老baseUrl的所有信息
     *
     * @param urlValue url
     * @return com.jiliguala.niuwa.coremodel.http.manager.UrlMgr
     */
    fun setUrl(urlValue: String): UrlMgr {
        urlMap?.put(DEFAULT_URL_KEY,urlValue)
        return this
    }

    /**
     * 获取全局唯一的baseUrl
     *
     * @return url
     */
    fun getUrl(): String? {
        return getUrlByKey(DEFAULT_URL_KEY)
    }

    /**
     * 根据key
     *
     * @param urlKey 获取对应的url
     * @return url
     */
    fun getUrlByKey(urlKey: String): String? {
        return urlMap?.get(urlKey)
    }

    /**
     * 清空设置的url相关的所以信息
     * 相当于重置url
     * 动态切换生产测试环境时候调用
     *
     * @return com.jiliguala.niuwa.coremodel.http.manager.UrlMgr
     */
    fun clear(): UrlMgr {
        urlMap?.clear()
//        ApiFactory.getInstance().clearAllApi()
//        ApiMgr.removeAllCookie()
        return this
    }
}