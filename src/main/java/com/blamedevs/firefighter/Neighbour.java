package com.blamedevs.firefighter;

public enum Neighbour {
    DownLeft(-1, -1), Down(0, -1), DownRight(1, -1),
    Left(-1, 0), Right(1, 0),
    TopLeft(-1, 1), Top(0, 1), TopRight(1, 1);

    private final int dx;
    private final int dy;

    Neighbour(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Position neighborPosition(Position position) {
        return new Position(position.x() + dx, position.y() + dy);
    }
}
