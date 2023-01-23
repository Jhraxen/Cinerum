package model
//crea una clase per la api sunrise-sunset
class ModelResults {
   var sunrise: String? = null
    var sunset: String? = null
    var solar_noon: String? = null
    var day_length: String? = null
    var civil_twilight_begin: String? = null
    var civil_twilight_end: String? = null
    var nautical_twilight_begin: String? = null
    var nautical_twilight_end: String? = null
    var astronomical_twilight_begin: String? = null
    var astronomical_twilight_end: String? = null

    @JvmName("getSunrise1")
    public fun getSunrise(): String? {
        return sunrise
    }
    @JvmName("setSunrise1")
    public fun setSunrise(sunrise: String?) {
        this.sunrise = sunrise
    }
    @JvmName("getSunset1")
    public fun getSunset(): String? {
        return sunset
    }
    @JvmName("setSunset1")
    public fun setSunset(sunset: String?) {
        this.sunset = sunset
    }
    @JvmName("getSolar_noon1")
    public fun getSolar_noon(): String? {
        return solar_noon
    }
    @JvmName("setSolar_noon1")
    public fun setSolar_noon(solar_noon: String?) {
        this.solar_noon = solar_noon
    }
    @JvmName("getDay_length1")
    public fun getDay_length(): String? {
        return day_length
    }
    @JvmName("setDay_length1")
    public fun setDay_length(day_length: String?) {
        this.day_length = day_length
    }
    @JvmName("getCivil_twilight_begin1")
    public fun getCivil_twilight_begin(): String? {
        return civil_twilight_begin
    }
    @JvmName("setCivil_twilight_begin1")
    public fun setCivil_twilight_begin(civil_twilight_begin: String?) {
        this.civil_twilight_begin = civil_twilight_begin
    }
    @JvmName("getCivil_twilight_end1")
    public fun getCivil_twilight_end(): String? {
        return civil_twilight_end
    }
    @JvmName("setCivil_twilight_end1")
    public fun setCivil_twilight_end(civil_twilight_end: String?) {
        this.civil_twilight_end = civil_twilight_end
    }
    @JvmName("getNautical_twilight_begin1")
    public fun getNautical_twilight_begin(): String? {
        return nautical_twilight_begin
    }
    @JvmName("setNautical_twilight_begin1")

    public fun setNautical_twilight_begin(nautical_twilight_begin: String?) {
        this.nautical_twilight_begin = nautical_twilight_begin
    }
    @JvmName("getNautical_twilight_end1")

    public fun getNautical_twilight_end(): String? {
        return nautical_twilight_end
    }
    @JvmName("setNautical_twilight_end1")
    public fun setNautical_twilight_end(nautical_twilight_end: String?) {
        this.nautical_twilight_end = nautical_twilight_end
    }
    @JvmName("getAstronomical_twilight_begin1")
    public fun getAstronomical_twilight_begin(): String? {
        return astronomical_twilight_begin
    }
    @JvmName("setAstronomical_twilight_begin1")
    public fun setAstronomical_twilight_begin(astronomical_twilight_begin: String?) {
        this.astronomical_twilight_begin = astronomical_twilight_begin
    }
    @JvmName("getAstronomical_twilight_end1")

    public fun getAstronomical_twilight_end(): String? {
        return astronomical_twilight_end
    }
    @JvmName("setAstronomical_twilight_end1")
    public fun setAstronomical_twilight_end(astronomical_twilight_end: String?) {
        this.astronomical_twilight_end = astronomical_twilight_end
    }

    override fun toString(): String {
        return "ModelResults(sunrise=$sunrise, sunset=$sunset, solar_noon=$solar_noon, day_length=$day_length, civil_twilight_begin=$civil_twilight_begin, civil_twilight_end=$civil_twilight_end, nautical_twilight_begin=$nautical_twilight_begin, nautical_twilight_end=$nautical_twilight_end, astronomical_twilight_begin=$astronomical_twilight_begin, astronomical_twilight_end=$astronomical_twilight_end)"
    }

}