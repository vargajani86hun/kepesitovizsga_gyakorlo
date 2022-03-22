package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        checkContacts(contacts);
        checkOutput(output);

        Path file = Path.of(output);
        try {
            Files.write(file, contacts.entrySet().stream().map(this::recordToString).toList(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!", ioe);
        }
    }

    private void checkOutput(String output) {
        if (output == null || output.isEmpty()) throw new IllegalArgumentException("File name must not be empty!");
    }

    private void checkContacts(Map<String, String> contacts) {
        if (contacts == null) throw new IllegalArgumentException("There are no contacts!");
    }

    private String recordToString(Map.Entry<String, String> phonebookRecord) {
        return phonebookRecord.getKey() + ": " + phonebookRecord.getValue();
    }
}
