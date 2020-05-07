import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {
    private static final InfluxDB INFLUXDB = InfluxDBFactory.connect("http://192.168.99.102:8086", "admin", "745746lkj");
    private static final String DATABASE = "selenium";

    static {
        INFLUXDB.setDatabase(DATABASE);
    }

    public static void send(final Point point) {
        INFLUXDB.write(point);
    }
}
