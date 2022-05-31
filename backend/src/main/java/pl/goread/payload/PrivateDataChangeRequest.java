package pl.goread.payload;

public record PrivateDataChangeRequest(String newPassword, String PESEL, String oldPassword) {
}
