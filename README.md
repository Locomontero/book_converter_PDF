# Book Converter Application

## Overview
The Book Converter Application is a powerful tool designed to streamline the conversion of books stored in a database into JSON format, and subsequently transform that JSON into a PDF file. This application is ideal for managing and distributing book data in a structured and readable format.

## Features
- Extract books and their related data from a PostgreSQL database.
- Convert the extracted data into JSON format using the Jackson library.
- Generate high-quality PDF files from the JSON data using iTextPDF.

## Technologies Used
- **Java 17**: Modern, robust programming language.
- **Spring Boot**: Framework for building enterprise-grade applications.
- **Maven**: Dependency management and build automation tool.
- **PostgreSQL**: Relational database for storing book data.

## Dependencies
- **Jackson**: For JSON processing (serialization and deserialization).
- **Lombok**: To simplify boilerplate code like getters, setters, and constructors.
- **iTextPDF**: For creating and manipulating PDF documents.

## How It Works
1. **Data Retrieval**: The application fetches book data from a PostgreSQL database using Spring Data JPA.
2. **JSON Conversion**: The retrieved data is converted to JSON format with the Jackson library.
3. **PDF Generation**: The JSON data is transformed into a formatted PDF document using iTextPDF.

## Setup Instructions

### Prerequisites
- **Java 17** installed.
- **Maven** installed.
- **PostgreSQL** installed and running.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Locomontero/book_converter_PDF.git
   ```
2. Navigate to the project directory:
   ```bash
   cd book_converter_PDF
   ```
3. Configure the database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourDatabase
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build the application using Maven:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   java -jar target/book_converter_PDF.jar
   ```

## Usage
1. **Database Setup**: Ensure your PostgreSQL database is populated with the necessary book data.
2. **Conversion**: The application will automatically extract the book data, convert it to JSON, and generate the corresponding PDF.
3. **Output**: Check the output directory for the generated PDF files.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contributions
Contributions are welcome! Feel free to fork the repository, create a feature branch, and submit a pull request.

## Contact
For inquiries or support, please contact [your_email@example.com].

