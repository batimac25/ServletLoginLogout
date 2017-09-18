<img src="http://localhost:8888/serve?blob-key-image=<%=session.getAttribute("blob-key-image")%>" width="150" height="150"/>
<br><br>
<video  controls>
<source src="http://localhost:8888/servevideo?blob-key-video=<%=session.getAttribute("blob-key-video")%>" type="video/mp4">
</video>