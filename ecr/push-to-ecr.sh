aws ecr get-login-password --region region | docker login --username AWS --password-stdin aws_account_id.dkr.ecr.region.amazonaws.com

aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin xxxxxxxxxxxx.dkr.ecr.ap-south-1.amazonaws.com

