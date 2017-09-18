package com.login.httpsession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeys1 = blobs.get("myFile");
		List<BlobKey> blobKeys2 = blobs.get("myVideo");

		HttpSession session = req.getSession();
		session.setAttribute("blob-key-image", blobKeys1.get(0).getKeyString());
		session.setAttribute("blob-key-video", blobKeys2.get(0).getKeyString());
		if (blobKeys1 == null || blobKeys1.isEmpty()) {
			req.getRequestDispatcher("ErrorPage.html");
		} else {
			req.getRequestDispatcher("profile.jsp").forward(req, resp);

		}

	}
}