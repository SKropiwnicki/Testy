Given a messenger
When testing connection with Invalid Server
Then testConnection should return 1

When testing connection with Valid Server
Then testConnection should return 0

When sending valid message
Then sendMessage should return 0 or 1

When sending invalid message
Then sendMessage should return 2

