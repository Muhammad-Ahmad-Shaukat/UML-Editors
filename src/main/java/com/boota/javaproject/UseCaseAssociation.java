package com.boota.javaproject;

public class UseCaseAssociation {
    private Point start;
    private Point end;
    private UseCase useCase;
    private UseCaseActor actor;

    public UseCaseAssociation(Point start, Point end, UseCase useCase, UseCaseActor actor) {
        this.start = start;
        this.end = end;
        this.useCase = useCase;
        this.actor = actor;
    }

    public UseCaseAssociation(Point start, Point end, UseCase useCase) {
        this(start, end, useCase, null);
    }


    public UseCaseActor getActor() {
        return actor;
    }

    public void setActor(UseCaseActor actor) {
        this.actor = actor;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public UseCase getUseCase() {
        return useCase;
    }

    public void setUseCase(UseCase useCase) {
        this.useCase = useCase;
    }

    public boolean isPointOnLine(Point point) {
        double tolerance = 5.0;
        double lineLength = Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
        double area = Math.abs((point.getX() - start.getX()) * (end.getY() - start.getY()) -
                (point.getY() - start.getY()) * (end.getX() - start.getX()));
        double distanceFromLine = area / lineLength;

        if (distanceFromLine > tolerance) {
            return false;
        }
        return (point.getX() >= Math.min(start.getX(), end.getX()) &&
                point.getX() <= Math.max(start.getX(), end.getX()) &&
                point.getY() >= Math.min(start.getY(), end.getY()) &&
                point.getY() <= Math.max(start.getY(), end.getY()));
    }
}
