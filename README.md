# SecureShift

SecureShift is a Java-based intermediary server designed to enhance security and control over client-server communication. It acts as a middleware between clients and servers, providing access control and data forwarding functionality.

## Technology/Tools Used

- Java
- TCP/IP Socket Programming
- Ubuntu OS (Virtual Box)

## Features

- Access Control: SecureShift verifies the client's IP address against a whitelist to ensure authorized access.
- Intermediary Security: By acting as an intermediary, SecureShift adds an additional layer of security to the communication process.
- Seamless Integration: SecureShift seamlessly integrates into existing client-server architectures with minimal configuration changes.

## Usage

1. Start the Server: Run the Server.java program on the machine where you want to receive data.
2. Start the Proxy Server: Run the ProxyServer.java program on an intermediate machine between the client and the server.
3. Run the Client: Use the Client.java program to send data to the proxy server.

![Screenshot (1302)](https://github.com/ItsJupiter000/SecureShift/assets/120741895/15d31be1-2768-4045-865c-c16d0db550ee)


### Authorized IP Address Scenario

In this scenario, the client's IP address is authorized by the proxy server. The client successfully sends data to the server through the proxy without any interruption.

![Screenshot (1299)](https://github.com/ItsJupiter000/SecureShift/assets/120741895/b7b3e54d-c2e6-47f6-9636-48f538f53716)
![Screenshot (1298)](https://github.com/ItsJupiter000/SecureShift/assets/120741895/0002dd0d-d2e1-4b38-b712-d9f39eb43e81)

### Unauthorized IP Address Scenario

In this scenario, the client's IP address is not authorized by the proxy server. The proxy server denies the client's connection attempt, preventing the client from sending data to the server.

![Screenshot (1300)](https://github.com/ItsJupiter000/SecureShift/assets/120741895/a2f4dbcc-9379-4111-8ac4-911cc5ae32bc)
![Screenshot (1301)](https://github.com/ItsJupiter000/SecureShift/assets/120741895/2a9c183c-8eaf-46b9-a3c9-da2063b117bc)


## Use Cases

1. Enterprise Security: SecureShift ensures only authorized devices within the corporate network can access sensitive servers, enhancing network security.
2. IoT Access Control: SecureShift restricts access to IoT device servers, allowing only authenticated devices to communicate, bolstering IoT security.
3. Remote Access: SecureShift enables secure remote access to internal servers, ensuring confidentiality and integrity of data transmission.
4. Content Filtering: SecureShift can be used in educational institutions for content filtering, ensuring compliance and protecting users from inappropriate content.

## Configuration

- Whitelist: Add authorized IP addresses to the ALLOWED_IPS set in the Proxy.java file.
- Proxy Port: Choose a port number for the proxy server and update the PROXY_PORT constant in the Proxy.java file.


