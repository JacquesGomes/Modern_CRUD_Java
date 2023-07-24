#!/bin/bash

# Remove files from cache based on .gitignore patterns

# Define the patterns to remove from cache
PATTERNS=(
    './*/.idea'
    './*/gradle/*'
    './*/gradlew'
    './*/gradlew.*'
    '.idea/'
)

# Loop through each pattern and remove matching files from cache
for pattern in "${PATTERNS[@]}"; do
    git rm -r --cached $pattern
done

# Commit the changes
git commit -m "Remove files from cache based on .gitignore patterns"

