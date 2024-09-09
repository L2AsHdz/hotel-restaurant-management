package com.sa.employeemicroservice.position.infraestructure.input.adapter.restapi;

import com.sa.employeemicroservice.common.WebAdapter;
import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.application.usecase.createposition.PositionRequestDto;
import com.sa.employeemicroservice.position.infraestructure.input.port.CreatePositionInputPort;
import com.sa.employeemicroservice.position.infraestructure.input.port.FindPositionByUuidInputPort;
import com.sa.employeemicroservice.position.infraestructure.input.port.ListPositionInputPort;
import com.sa.employeemicroservice.position.infraestructure.input.port.UpdatePositionInputPort;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@WebAdapter
@RequestMapping("/v1/position")
@RequiredArgsConstructor
public class PositionRestAdapter {

    private final CreatePositionInputPort createPositionInputPort;
    private final UpdatePositionInputPort updatePositionInputPort;
    private final ListPositionInputPort listPositionInputPort;
    private final FindPositionByUuidInputPort findPositionByUuidInputPort;

    @GetMapping
    public ResponseEntity<List<PositionResponseDto>> list() {
        var positions = listPositionInputPort.listPositions().stream().map(PositionResponseDto::from).toList();

        return ResponseEntity.ok(positions);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PositionResponseDto> findByUuid(@PathVariable UUID uuid) throws EntityNotFoudException {
        var position = findPositionByUuidInputPort.findPositionByUuid(uuid);

        return ResponseEntity.ok(PositionResponseDto.from(position));
    }

    @PostMapping
    public ResponseEntity<PositionResponseDto> create(@RequestBody @Valid PositionRequestDto positionRequestDto) throws DuplicatedEntityException {
        var position = createPositionInputPort.createPosition(positionRequestDto);

        return ResponseEntity.ok(PositionResponseDto.from(position));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<PositionResponseDto> update(@PathVariable UUID uuid, @RequestBody @Valid PositionRequestDto positionRequestDto) throws EntityNotFoudException, DuplicatedEntityException {
        var position = updatePositionInputPort.updatePosition(uuid, positionRequestDto);

        return ResponseEntity.ok(PositionResponseDto.from(position));
    }

}
