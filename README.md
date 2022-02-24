# jenkins
## Learning jenkinspipeline constructs

## Automatically create Let's Encrypt Certificate
#sudo certbot --nginx -d jenkins.singhjee.in -d www.jenkins.singhjee.in
Update the Route53 records before running the command
Also from SGs allow port 80 for ACME
sudo certbot --nginx -d jenkins.singhjee.in
0 12 * * * /usr/bin/certbot renew --quiet
