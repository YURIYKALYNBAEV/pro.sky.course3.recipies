package pro.sky.me.kalinbaev.cookingrecipes.model.info;

import pro.sky.me.kalinbaev.cookingrecipes.model.exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.util.Objects;

public class InfoProject {
    private String author;
    private String title;
    private LocalDate localDate;
    private String description;

    public InfoProject(String author,
                       String title,
                       LocalDate localDate,
                       String description) throws IncorrectArgumentException {
        setAuthor(author);
        setTitle(title);
        setLocalDate(localDate);
        setDescription(description);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IncorrectArgumentException {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            throw new IncorrectArgumentException("автор проекта");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException("название проекта");
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) throws IncorrectArgumentException {
        if (localDate != null) {
            this.localDate = localDate;
        } else {
            throw new IncorrectArgumentException("дата создания проекта");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description != null) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException("описание проекта");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProject that = (InfoProject) o;
        return Objects.equals(author, that.author)
                && Objects.equals(title, that.title)
                && Objects.equals(localDate, that.localDate)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, localDate, description);
    }

    @Override
    public String toString() {
        return "Автор проекта: " + author + ". " + "</br>" +
                "Название проекта: " + title + ". " + "</br>" +
                "Дата создания проекта: " + localDate + ". " + "</br>" +
                "Описание проекта: </br>" + description;
    }
}
