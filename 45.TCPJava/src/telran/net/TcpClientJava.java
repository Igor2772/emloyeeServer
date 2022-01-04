package telran.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientJava implements Closeable
{
	protected ObjectOutputStream output;
	protected ObjectInputStream input;
	protected Socket socket;

	public TcpClientJava(String hostName, int port) throws UnknownHostException, IOException
	{
		socket = new Socket(hostName, port);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void close() throws IOException
	{
		socket.close();
	}

	@SuppressWarnings("unchecked")
	protected <T> T sendRequest(String requestType, Serializable requestData) 
	{
		try
		{
			RequestJava request = new RequestJava(requestType, requestData);
			output.writeObject(request);
			ResponseJava response = (ResponseJava) input.readObject();
			if (response.code != TcpResponseCode.OK)
				throw new Exception(response.code.toString());
			return (T) response.responseData;
		} 
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
}
