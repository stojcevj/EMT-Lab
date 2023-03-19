package com.example.emtlab.config;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.AuthorDto;
import com.example.emtlab.model.dto.BookDto;
import com.example.emtlab.model.dto.CountryDto;
import com.example.emtlab.model.enumerations.Category;
import com.example.emtlab.model.enumerations.UserAuthorities;
import com.example.emtlab.service.AuthorService;
import com.example.emtlab.service.BookService;
import com.example.emtlab.service.CountryService;
import com.example.emtlab.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataInitializer {
    private final UserService userService;
    private final BookService bookService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(UserService userService, BookService bookService, PasswordEncoder passwordEncoder, AuthorService authorService, CountryService countryService) {
        this.userService = userService;
        this.bookService = bookService;
        this.passwordEncoder = passwordEncoder;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
        userService.createUser("Jovan","stojcevjovan@hotmail.com","joci123", UserAuthorities.LIBRARIAN);

        for(int i=0; i<10; i++){
            Country tmpCountry = countryService.saveCountry(new CountryDto("Country " + i, "Continent " + i)).get();
            Author tmpAuthor = authorService.saveAuthor(new AuthorDto("Name " + i,"Surname " + i, tmpCountry.getId())).get();
            BookDto tmpBook = new BookDto("bookName " + i, Category.values()[i % 5],tmpAuthor.getId(), i);
            bookService.saveBook(tmpBook);
        }
    }
}
