## Generate Vouchers

Task:
Write a program in Java, which when run would generate a list of voucher codes based on "voucher type" and "number of vouchers to generate".
Requirements:
Any generator implementations are valid, but you have to use at least two different algorithms. Just updating the generator type or quantity in the configuration should be enough to get a different list of voucher codes.

The application will take a file path from a command line argument, read in the contents of the file and output the result to stdout.

* I've decided to pass a file into the command line for scalability purposes, so if we want to generate hundreds of different vouchers types it is easier to handle it, and
and also for reusability so we can use the same data input more than once. 
* I've also made the assumption that it would be useful to know the voucher type from the generated number, so I add the voucher_Type ID as a prefix of the final voucher code.

* I've added 2 more parameters into the input instruction so now it looks like: [voucher_type, amount_of_vouchers, algorithm_type, lower_range, upper_range]
I've thought that, having the possibility to pass into the application the lower and upper range gives much more flexibility at the moment of generating the sequences of numbers.
* I've also made the vouchers and the algorithms type to be strongly typed, so it is easy to spot a error in the input instruction.

* Into the bin directory you will find an executable that is nothing else than a wrapping script calling the vouchersTask.jar artifact.
* In order to guaranty to that the functionality, I've introduced a set of tests where I check the core functionalities of the application.
Examples:

 Invocation:
     ./vouchersTask vouchersGenerator.txt
     
File Contents:
    voucher_type_1 5 sequentialNumbers 0 100
    voucher_type_2 2 sequentialNumbers 0 10
    voucher_type_3 3 sequentialNumbers 0 20

Output to stdout:
    voucher_type_0
    0 00001
    0 00002
    0 00003
    0 00004
    0 00005
    voucher_type_1
    1 00001
    1 00002
    voucher_type_2
    2 00001
    2 00002
    2 00003

