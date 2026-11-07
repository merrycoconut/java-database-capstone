# README

### How to Open MongoDB shell
1. Install MongoDB Sheel in your PC
    
    (macOS with homebrew)
    
    Open your terminal and run:
    ```bash
    brew install mongosh
    ```
2. Download MongoDB Community Server through official website: https://www.mongodb.com/try/download/community

3. Opens the MongoDB shell

    (macOS)
    
    1. Open your terminal and naviagte to the downloaded folder
    2. Create a database directory

        ```bash
        sudo mkdir -p /data/db
        ```
    3. Start MongoDB database server

        ```bash
        ./mongod
        ```
    4. Open another terminal and execute

        ```bash
        ./mongo
        ```
        This opens the MongoDB shell, allowing you to execute database commands.

Note: type ```exit``` in terminal to exit from the MongoDB shell.