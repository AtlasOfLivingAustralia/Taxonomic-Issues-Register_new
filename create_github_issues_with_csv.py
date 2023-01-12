"""Create GitHub issues with CSV using GitHub CLI """

import argparse
import asyncio
import csv
import io
import sys
from asyncio import create_subprocess_exec
from asyncio.subprocess import PIPE
from asyncio.tasks import as_completed
from pprint import pprint
from functools import partial
from typing import Generator

REPO = "[TaniaGLaity]/[Taxonomic-Issues-Register]"
PROJECT = "[Taxonomy]"
DATA = """
Milestone 1,Task 1
Milestone 1,Task 2
Milestone 1,Task 3
Milestone 2,Task 4
Milestone 2,Task 5
"""

# Type aliases
Program = str
CommandArgs = list[str]
Command = tuple[Program, CommandArgs]
CommandOutput = tuple[str, str]


async def main() -> None:
    """Main function"""
    args = get_args()
    dry_run = args.dry_run

    issues = [x for x in read_data(DATA)]

    build_command_ = partial(build_command, body="", repo=REPO, project=PROJECT)
    commands = [
        build_command_(title=title, milestone=milestone) for milestone, title in issues
    ]

    if dry_run:
        pprint(commands)
        return

    await run_all(commands)


def get_args() -> argparse.Namespace:
    """Get CLI args"""
    parser = argparse.ArgumentParser(__doc__)
    parser.add_argument('--dry-run', action='store_true')
    return parser.parse_args()


def read_data(csv_text: str) -> Generator[list[str], None, None]:
    """Load issue data from CSV text"""
    reader = csv.reader(io.StringIO(csv_text))
    for row in reader:
        if not row:
            continue
        yield row


def build_command(
    repo: str, title: str, body: str, milestone: str, project: str
) -> Command:
    """Build command to create an issue with GitHub CLI"""
    return (
        "gh",
        [
            "issue",
            "create",
            "--repo",
            repo,
            "--title",
            title,
            "--body",
            body,
            "--milestone",
            milestone,
            "--project",
            project,
        ],
    )


async def run_all(commands: list[Command]):
    """Run multiple commands"""
    for coro in asyncio.as_completed([run(command) for command in commands]):
        stdout, stderr = await coro
        print(stdout.rstrip())
        if stderr:
            print(stderr.rstrip(), file=sys.stderr)


async def run(command: Command) -> CommandOutput:
    """Run a subprocess"""
    program, args = command
    print(program, *args)
    proc = await create_subprocess_exec(program, *args, stdout=PIPE, stderr=PIPE)
    stdout, stderr = await proc.communicate()
    await proc.wait()

    return stdout.decode(), stderr.decode()


if __name__ == "__main__":
    asyncio.run(main())
    
