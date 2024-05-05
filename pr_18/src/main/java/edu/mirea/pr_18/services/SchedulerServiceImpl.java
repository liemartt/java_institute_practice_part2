package edu.mirea.pr_18.services;

import edu.mirea.pr_18.dto.BookDto;
import edu.mirea.pr_18.entities.Author;
import edu.mirea.pr_18.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {
    private final BookService bookService;
    private final AuthorService authorService;
    private final String url = "D:\\JavaLearning\\JavaInstitute\\src\\java_institute_practice_part2\\pr_18\\src\\main\\resources\\entityData";
    @Override
    @Scheduled(cron = "0 */30 * * * *")
    public void doSheduledTask() throws IOException {
        File dir = new File(url);
        clearDirectory(dir);
        saveEntityDataToFiles(dir);
    }

    private void saveEntityDataToFiles(File dir) throws IOException {
        List<BookDto> books = bookService.getBooks();
        List<Author> authors = authorService.getAuthors();
        writeToFile(url+"/book.txt", books.toString());
        writeToFile(url+"/author.txt", authors.toString());

    }


    private void clearDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
    private void writeToFile(String fileName, String content) throws IOException {
        try {
            Path newFilePath = Paths.get(fileName);
            Files.createFile(newFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
