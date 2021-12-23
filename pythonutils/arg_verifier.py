

import argparse


def parse_command_line():
    parser = argparse.ArgumentParser()

    parser.add_argument("-a", "--account",
                        default=None, required=False,
                        help=("Target AWS region"))
    parser.add_argument("-r", "--region",
                        default=None, required=True,
                        help=("Target AWS region"))
    parser.add_argument("-n", "--dry-run", action='store_true',
                        default=False, required=False,
                        help=("Print out the images but don't delete it "))
    parser.add_argument("-t", "--title",
                        default=None, required=False,
                        help=("Inspector vulnerability title to search for"))
    args = parser.parse_args()
    return args

def main():
    parse_command_line()
    print("This is my testing file")


if __name__ == '__main__':
    main()