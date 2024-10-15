package gradle.demo.entity.base;

import gradle.demo.entity.Position;
import gradle.demo.enums.PieceType;
import gradle.demo.enums.Side;
import lombok.Builder;

@Builder ( toBuilder = true )
public record Piece ( PieceType type, Side side, Position position ) {
}
