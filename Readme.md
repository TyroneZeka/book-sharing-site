# Book Sharing Application

BookShare is a collaborative platform for book enthusiasts to share and exchange books. This application is built with a Java backend and an Angular front-end to deliver a seamless user experience. Whether you're looking to lend your favorite books or find new ones to read, BookShare provides a user-friendly interface to manage your personal library and connect with fellow readers.
## Features

- **User Authentication**: Secure login and registration functionality with email support.
- **Book Listings**: Browse a comprehensive list of available books.
- **Search Functionality**: Search for books by title, author.
- **Book Details**: View detailed information about each book, including description,cover, author, and availability status.
- **Borrow and Return Books**: Request to borrow a book and mark it as returned once you're done.
- **Admin Panel**: Admin functionalities to add, update, or remove book listings and manage users.

## Tech Stack

- **Backend**: Java with Spring Boot
- **Frontend**: Angular
- **Database**: Postgres
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven for Java, Angular CLI for Angular
- **REST API**: For communication between the frontend and backend

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Java 17+
- Node.js and npm
- Angular CLI
- Postgres

### Installation

1. **Clone the repository**
    ```sh
    git clone https://github.com/TyroneZeka/book-sharing-site.git
    cd book-sharing-site
    ```

2. **Backend Setup**
    - Navigate to the backend directory
      ```sh
      cd book-social-network
      ```
    - Install dependencies and build the project
      ```sh
      mvn clean install
      ```
    - Configure the database connection in `src/main/resources/application-dev.properties`
    - Run the backend server
      ```sh
      mvn spring-boot:run
      ```

3. **Frontend Setup**
    - Navigate to the frontend directory
      ```sh
      cd frontend
      ```
    - Install dependencies
      ```sh
      npm install
      ```
    - Run the frontend server
      ```sh
      ng serve
      ```

### Usage

Once both the backend and frontend servers are running, you can access the application at `http://localhost:4200`. Register or log in to start sharing and borrowing books!

## Contributing

We welcome contributions! Please fork the repository and create a pull request with your changes. Ensure you follow the coding standards and write tests for any new functionality.

1. **Fork the repository**
2. **Create your feature branch**
    ```sh
    git checkout -b feature/your-feature-name
    ```
3. **Commit your changes**
    ```sh
    git commit -m 'Add some feature'
    ```
4. **Push to the branch**
    ```sh
    git push origin feature/your-feature-name
    ```
5. **Create a new Pull Request**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, feel free to open an issue or reach out to me at .link-style1[[mufasadev@zohomail.com](mailto:example@gmail.com)].

---

Happy Book Sharing!
