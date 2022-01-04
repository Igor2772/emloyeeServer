package telran.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable
{
	int port;
	ServerSocket serverSocket;
	ProtocolJava protocol;

	public ServerJava(ProtocolJava protocol, int port) throws IOException
	{
		super();
		this.port = port;
		this.protocol = protocol;
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run()
	{
		System.out.println("Started and listeninig in port " + port);
		try
		{
			while (true)
			{
				Socket socket = serverSocket.accept();
				ServerClientJava worker = new ServerClientJava(socket, protocol);
				worker.run();
			}
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
