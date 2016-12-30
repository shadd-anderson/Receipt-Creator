This program takes a shopping list in the form of an input text file, and creates a receipt for the list.

Shopping lists MUST be in the following format, with separate items on separate lines: 

[quantity] [item description] at [price]

There are also a few constants that can be changed depending on the context:

1) EXCLUDED_ITEMS - A list of Strings containing descriptions of items that are exempt from taxation.
2) STANDARD_TAX - The standard tax rate
3) IMPORT_TAX - The tax rate on "imported" items

The tax rates should be in decimal format (0.1 instead of 10%, 0.05 instead of 5%, etc).

Sample inputs are included in the project directory.



To run the program:
Simply type the following command into a console or command line while in the project directory:

gradle run -Pfile=[path/to/file]

Where path/to/file is the path to the input files. You can also enter multiple inputs at one time by simply separating the paths with commas. For example:

gradle run -Pfile=./test1.txt,./test2.txt,./test3.txt
