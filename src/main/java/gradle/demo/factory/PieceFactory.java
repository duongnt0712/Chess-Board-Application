package gradle.demo.factory;

import gradle.demo.entity.Position;
import gradle.demo.entity.base.Piece;
import gradle.demo.enums.PieceType;
import gradle.demo.enums.Side;

public class PieceFactory {

    public Piece create(PieceType type, Side side, Position position) {
//        return Piece.builder().type(type).side(side).position(position).build();
        return new Piece(type, side, position);
    }

}
