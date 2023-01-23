package model

class ModelApi {
    var status: String? = null
    var results: ModelResults? = null

    @JvmName("getStatus1")
    public fun getStatus(): String? {
        return status
    }
    @JvmName("setStatus1")
    public fun setStatus(status: String?) {
        this.status = status
    }
    @JvmName("getResults1")
    public fun getResults(): ModelResults? {
        return results
    }

    @JvmName("setResults1")
    public fun setResults(results: ModelResults?) {
        this.results = results
    }

}