package map;

public class MapRequestEntity {
    private String ak;
    private String origin;
    private String destination;
    private String origin_uid;
    private String destination_uid;
    private String waypoints;
    private String coord_type;
    private String ret_coordtype;
    private Integer tactics;
    private String alternatives;
    private String plate_number;
    private String ext_departure_time;
    private String gps_direction;
    private Float radius;
    private Float speed;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin_uid() {
        return origin_uid;
    }

    public void setOrigin_uid(String origin_uid) {
        this.origin_uid = origin_uid;
    }

    public String getDestination_uid() {
        return destination_uid;
    }

    public void setDestination_uid(String destination_uid) {
        this.destination_uid = destination_uid;
    }

    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
        this.waypoints = waypoints;
    }

    public String getCoord_type() {
        return coord_type;
    }

    public void setCoord_type(String coord_type) {
        this.coord_type = coord_type;
    }

    public String getRet_coordtype() {
        return ret_coordtype;
    }

    public void setRet_coordtype(String ret_coordtype) {
        this.ret_coordtype = ret_coordtype;
    }

    public Integer getTactics() {
        return tactics;
    }

    public void setTactics(Integer tactics) {
        this.tactics = tactics;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getExt_departure_time() {
        return ext_departure_time;
    }

    public void setExt_departure_time(String ext_departure_time) {
        this.ext_departure_time = ext_departure_time;
    }

    public String getGps_direction() {
        return gps_direction;
    }

    public void setGps_direction(String gps_direction) {
        this.gps_direction = gps_direction;
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    private String output = "json";
    private String sn;
    private Long timestamp;
    private String callback;
}
