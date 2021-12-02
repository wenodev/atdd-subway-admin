package nextstep.subway.common.exception;

public class NotContainsStationException extends RuntimeException {
    public static final String NOT_CONTAINS_STATION_MESSAGE = "현재 입력된 역들이 노선에 존재하지 않습니다. %s, %s";

    public NotContainsStationException(String upStationName, String downStationName) {
        super(String.format(NOT_CONTAINS_STATION_MESSAGE, upStationName, downStationName));
    }
}