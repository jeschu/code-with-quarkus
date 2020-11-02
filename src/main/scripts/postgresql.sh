#!/usr/bin/env zsh

function run() {
  docker run -d --rm --name pg-code-with-quarkus \
            -p 54320:5432 \
            -e POSTGRES_DB=world \
            -e POSTGRES_USER=quarkus \
            -e POSTGRES_PASSWORD=world \
            postgres:13
}

run