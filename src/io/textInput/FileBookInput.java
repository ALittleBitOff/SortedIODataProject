package io.textInput;

import data.Book;

public class FileBookInput extends FileReaderDataInput<Book> {
        @Override
        protected Book parseLine(String[] parts) throws NumberFormatException {
            String author = parts[0].trim();
            String title = parts[1].trim();
            int pageCount = Integer.parseInt(parts[2].trim());
            return new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPageCount(pageCount)
                    .build();
        }
}
