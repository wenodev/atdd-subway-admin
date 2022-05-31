package nextstep.subway.line.apllication;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.LineRepository;
import nextstep.subway.line.dto.LineRequest;
import nextstep.subway.line.dto.LineResponse;
import nextstep.subway.line.exception.LineNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public LineResponse create(LineRequest lineRequest) {
        Line line = lineRepository.save(lineRequest.toLine());
        return LineResponse.of(line);
    }

    public List<LineResponse> getLines() {
        List<Line> lines = lineRepository.findAll();
        return LineResponse.of(lines);
    }

    public LineResponse getLine(Long id) {
        Line line = lineRepository.findById(id).orElseThrow(LineNotFoundException::new);
        return LineResponse.of(line);
    }
}