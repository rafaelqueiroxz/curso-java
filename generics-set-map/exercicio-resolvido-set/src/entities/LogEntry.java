package entities;

import java.time.LocalDate;
import java.util.Objects;

public class LogEntry {

    private String username;
    private LocalDate moment;

    public LogEntry(String username, LocalDate moment) {
        this.username = username;
        this.moment = moment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(username, logEntry.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
