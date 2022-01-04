package telran.net.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.net.RequestJava;
import telran.net.ResponseJava;

public class ServerClientJava implements Runnable
{
	ObjectInputStream input;
	ObjectOutputStream output;
	Socket socket;
	ProtocolJava protocol;

	public ServerClientJava(Socket socket, ProtocolJava protocol) throws IOException
	{
		super();
		this.socket = socket;
		this.protocol = protocol;
		input = new ObjectInputStream(socket.getInputStream());
		output = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				RequestJava request = (RequestJava) input.readObject();
				ResponseJava response = protocol.getResponse(request);
				output.writeObject(response);
			}
		}
		catch (EOFException e)
		{
			System.out.println("Client closed connection");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
