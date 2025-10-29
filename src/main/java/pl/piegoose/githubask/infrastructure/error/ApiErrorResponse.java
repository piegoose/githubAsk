package pl.piegoose.githubask.infrastructure.error;

public record ApiErrorResponse(int status, String message) {
}
