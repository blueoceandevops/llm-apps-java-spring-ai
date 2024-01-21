# Prompts Messages: OpenAI

```shell
export SPRING_AI_OPENAI_API_KEY=<INSERT KEY HERE>
```

```shell
./gradlew bootTestRun
```

```shell
http --raw "What is the capital of Italy?" :8080/ai/chat/single
```

```shell
http --raw "What is the capital of Italy?" :8080/ai/chat/multiple
```

```shell
http --raw "What is the capital of Italy?" :8080/ai/chat/external
```