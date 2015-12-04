package services;
import java.io.File;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider ;
import com.amazonaws.services.s3.model.CannedAccessControlList;


public class FileUploader{
    public static String uploadMediaFile(File media){
        AmazonS3 s3client = new AmazonS3Client(new EnvironmentVariableCredentialsProvider());
        PutObjectRequest putObj= new PutObjectRequest("mediafiles.nuitinfo2015", media.getName(), media);
        putObj.setCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObj);
        return("https://s3-eu-west-1.amazonaws.com/mediafiles.nuitinfo2015/"+media.getName());
    }
}