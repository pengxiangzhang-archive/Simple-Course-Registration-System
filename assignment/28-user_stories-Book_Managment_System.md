# User Stories for Book Management System

-   As a library patron, I want to search for books by author or title so that
    I may be able to get their locations in the library so that I may easily
    find books I am interested in.
    -   There is a search function that allows patron to search by author or
        title.
    -   The system shows all books that meet search terms and whether they
        are available, or when they can next be available, along with their
        physical location on the shelves (physical location is indicated by
        the catalog number).

-   As a library patron, I want to browse an online catalog so that I can
    conveniently view the available titles.
    -   I can add books to my cart from the online catalog.
    -   I can view whether or not a book is available to checkout.

-   As a library patron, I want to be able to place a book on hold after having
    found it in the search utility so that I may check it out easily.
    -   There is an option to select book and reserve it to pick up later.
    -   If book is not available, the patron is added to queue of reservations
        so that it can be held for the patron when it becomes available.

-   As a library patron, I want to be notified that a book is available after
    requesting a hold so that I can check it out immediately when it is
    available.
    -   When receiving updates from the blackboard, the object representing
        this patron will recognize whether the update is relevant to it and
        will output an appropriate message if it is.
        -   This implementation-level criterion normally wouldn't be part of a
            user story, but I don't want you to have to figure out how to have
            your application send an email. 😉
    -   The patron at the head of the queue for a held book can check it out
        immediately.

-   As a library patron, I want to be able to keep track of all the books that
    I have checked-out so that I can evaluate my reading habits.
    -   I can see the details of the books I currently have checked-out,
        including the due dates.
    -   I can see the details of the books I checked out in the past, including
        when I checked them out and how long I had them checked out.

-   As a librarian, I want to be able to add a new book to our available
    catalog so our patrons can see the correct list of books in our library.
    -   After adding the book to the catalog, the catalog will show its title,
        author, catalog number, copy number, and summary.
    -   The added book will be able to be immediately checked out by a user.

-   As a librarian, I want to remove a single book from the library inventory
    so that our inventory accurately reflects what our library physically
    stores when we have to throw out a damaged book.
    -   When I remove a new book, the system prompts me for the catalog number
        of the book that we want to remove.
    -   A copy of the book that matches the catalog number I entered has been
        removed from the inventory.

-   As a librarian I want to be able to see how many students have put the same
    title on hold so that is one book is on hold by too many students I can
    order additional copies if there is enough demand.
    -   I can see how many copies of a title are in the catalog and how many
        holds are on that title.

-   As a librarian, I want to be able to edit a book's catalog entry so that
    our catalog always reflects the correct information to the best of our
    ability.
    -   If the changes were successfully made, the system will display the old
        and new information and confirm that the changes took effect.
    -   If the changes were not successfully made, the system will provide
        enough information for me to understand why.

-   As a librarian, I want to be able to manipulate a title's hold queue so
    that I can handle unusual situations.
    -   If I remove a patron who found the book elsewhere, then that patron
        will no longer have a hold on the book.
    -   If I place a patron who is a major donor to the library at the front of
        the queue then they will be able check out the book as soon as a copy
        is returned.
