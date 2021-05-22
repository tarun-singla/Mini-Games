#!/usr/local/bin/perl

# Lab 4

use strict;
use POSIX;

# Draw hangman
sub hangman {
    my ($h, $a1, $a2, $l1, $l2, $b1, $b2) = ("", "", "", "", "", "", "");
    my ($life) = @_;

    if ($life >= 1) {
        $h = "O";
    }
    if ($life >= 2) {
        $b1 = "|";
        $a1 = " ";
    }
    if ($life >= 3) {
        $a1 = "\\";
    }
    if ($life >= 4) {
        $a2 = "/";
    }
    if ($life >= 5) {
        $b2 = "|";
    }
    if ($life >= 6) {
        $l1 = "/";
    }
    if ($life >= 7) {
        $l2 = "\\";
    }

    print "__________\n";
    print "|    |\n";
    print "|    $h\n";
    print "|   $a1$b1$a2\n";
    print "|    $b2\n";
    print "|   $l1 $l2\n";
    print "|_____\n";
}

# Get a random word
sub getRandomWord {
    my @dictionary = ("computer", "radio", "calculator", "teacher", "bureau", "police", "geometry", "president", "subject", "country", "enviroment", "classroom", "animals", "province", "month", "politics", "puzzle", "instrument",
    "kitchen", "language", "vampire", "ghost", "solution", "service", "software", "security", "phonenumber", "expert", "website", "agreement", "support", "compatibility", "advanced", "search", "triathlon", "immediately",
    "encyclopedia", "endurance", "distance", "nature", "history", "organization", "international", "championship", "government", "popularity", "thousand", "feature", "wetsuit", "fitness", "legendary", "variation", "equal",
    "aimately", "segment", "priority", "physics", "branche", "science", "mathematics", "lightning", "dispersion", "accelerator", "detector", "terminology", "design", "operation", "foundation", "application", "prediction",
    "reference", "measurement", "concept", "perspective", "overview", "position", "airplane", "symmetry", "dimension", "toxic", "algebra", "illustration", "classic", "verification", "citation", "unusual", "resource",
    "analysis", "license", "comedy", "screenplay", "production", "release", "emphasis", "director", "trademark", "vehicle", "aircraft", "experiment");

    return $dictionary[floor(rand($#dictionary))];
}

# Get a dummy word containing only dashes
sub getDummyWord {
    my ($length) = @_;
    my $dummy = "";

    for (my $i = 0; $i < $length; $i++) {
        $dummy = $dummy."-";
    }

    return $dummy;
}

# Check user's guess
sub checkGuess {
    my ($word, $guess) = @_;

    if (index($word, $guess) == -1) {
        return 0;
    }

    return 1;
}

# Update dummy word
sub updateDummyWord {
    my ($word, $dummyWord, $guess) = @_;

    while (index($word, $guess) != -1) {
        my $i = index($word, $guess);
        substr($dummyWord, $i, 1) = $guess;
        substr($word, $i, 1) = "-";
    }

    return $dummyWord;
}

# Play game subroutine
sub playGame {
    my $word = getRandomWord();
    my $dummyWord = getDummyWord(length($word));

    my $life = 0; # Number of wrong guesses
    my $win = 0; # If win
    my $wrongGuesses = "";
    my $correctGuesses = "";

    print "\nTotal number of lives: 7\n";

    while ($life != 7) {
        print "\nWord: $dummyWord\n";
        print "Make a guess: ";
        my $guess = <STDIN>;
        chomp($guess);

        # Input check
        while (checkGuess($correctGuesses, $guess) || checkGuess($wrongGuesses, $guess)) {
            print "You have already guessed '$guess'\ \n";
            print "Make another guess: ";
            $guess = <STDIN>;
            chomp($guess);
        }

        # Guess check
        if (checkGuess($word, $guess)) {
            $correctGuesses = $correctGuesses.$guess;
            $dummyWord = updateDummyWord($word, $dummyWord, $guess);
            print "Good guess!\n";
        }
        else {
            $wrongGuesses = $wrongGuesses.$guess;
            $life++;
            print "Bad Guess!\n";
        }

        # Print data
        my $livesLeft = 7 - $life;
        print "Number of lives left: $livesLeft\n";

        print "Wrong guesses so far: ";
        if ($wrongGuesses eq "") {
            print "-\n";
        }
        else {
            print "$wrongGuesses\n";
        }

        # Print Hangman
        hangman($life);

        # Check win
        $win = !checkGuess($dummyWord, "-");
        if ($win) {
            last;
        }
    }

    print "\n";

    # End a particular game
    if ($win) {
        print "Word: $dummyWord\n";
        print "You won!\n"
    }
    else {
        print "You lost!\n";
        print "Word: $word\n";
    }
}

# Main program / Conductor
sub main {
    print "Welcome to Hangman! Try your best to save your man :)\n";
    print "Press [1] to play or [0] to exit: ";
    my $input = <STDIN>;

    # Handle input and call playGame
    while ($input != 0) {
        if ($input == 1) {
            playGame();
        }
        else {
            print "\nWrong input!";
        }

        print "\nWant to play again?\nPress [1] to play else [0] to exit: ";
        $input = <STDIN>;
    }

    print "Thank you for playing!\n";
}

# Start program
main();
