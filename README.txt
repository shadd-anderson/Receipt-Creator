To run the project:
Simply type the following command into a console or command line while in the project directory:

gradle run -Pfile=[path/to/file]

Where path/to/file is the path to the input files. You can also enter multiple inputs at one time by simply separating the paths with commas. For example:

gradle run -Pfile=./test1.txt,./test2.txt,./test3.txt