public class Pawn extends Piece {

    private boolean isFirstMove;

    public Pawn(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
        this.isFirstMove = true;
    }

    @Override
    public boolean possibleMove(int x, int y) {
        Piece piece = Board.getPiece(x, y);

        int dx = getX() - x;
        int dy = getY() - y;

        if (getColor() == Color.WHITE) {
            if (isFirstMove && dy == 2 && dx == 0 && Board.isPathClear(getX(), getY(), x, y) && piece == null) {
                return true;
            } else if (dy == 1 && dx == 0 && piece == null) {
                return true;
            } else if (dy == 1 && Math.abs(dx) == 1 && piece != null && !sameColor(piece)) {
                return true;
            }
        } else if (getColor() == Color.BLACK) {
            if (isFirstMove && dy == -2 && dx == 0 && Board.isPathClear(getX(), getY(), x, y) && piece == null) {
                return true;
            } else if (dy == -1 && dx == 0 && piece == null) {
                return true;
            } else if (dy == -1 && Math.abs(dx) == 1 && piece != null && !sameColor(piece)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return getColor() == Color.WHITE ? "♙" : "♟";
    }

    @Override
    public boolean canMove() {
        int x = getX();
        int y = getY();

        if (getColor() == Color.WHITE) {
            if (testMove(x, y - 1) || testMove(x, y - 2) || testMove(x - 1, y - 1) || testMove(x + 1, y - 1)) {
                return true;
            }
        } else if (getColor() == Color.BLACK) {
            if (testMove(x, y + 1) || testMove(x, y + 2) || testMove(x - 1, y + 1) || testMove(x + 1, y + 1)) {
                return true;
            }
        }

        return false;
    }
}