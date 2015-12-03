package services;
import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider ;

public class FileUploader{
    public static String uploadMediaFile(File media){
        AmazonS3 s3client = new AmazonS3Client(new EnvironmentVariableCredentialsProvider());
        s3client.putObject(new PutObjectRequest("mediafiles.nuitinfo2015", media.getName(), media));
        return("https://s3-eu-west-1.amazonaws.com/mediafiles.nuitinfo2015/"+media.getName());
    }
}